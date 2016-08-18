var ChartForm = (function(){
	
	var form            = {},
		chart           = {},
		burndown        = {};
	
	form.init = function() {
		form.load();
	};
	
	form.renderChart = function(burndown) {
		var xPoints = form.iterateNumber(burndown.numberDays, 1);
		
		
		chart = new Highcharts.Chart({
			chart: {
	            renderTo: 'chart',
	        },
	        credits: {
	      		enabled: false
	  			},
	        exporting: { 
	        	enabled: false 
	        },
  			xAxis: {
	            min: 1,
	            tickPositions: xPoints,
	            title: {
	                text: 'Days'
	            }
	        },
	        yAxis: {
	            min: 0,
	            max: burndown.numberTasks + (burndown.numberTasks / 5),
	            title: {
	                text: 'Tasks'
	            }
	        },
	        title: {
	            text: 'Burndown'
	        },
	        series: [{
	            type: 'line',
	            name: 'Tasks per day',
	            data: form.generateGoalTasksPerDay(xPoints, burndown.numberTasks),           
	            marker: {
	                enabled: true
	            },
	            states: {
	                hover: {
	                    lineWidth: 0
	                }
	            },
	            enableMouseTracking: false
	        },
	        
	        {
	            type: 'line',
	            name: 'Remaining tasks',
	            data: form.getRemainingTasks(burndown.tasksdays),
	            marker: {
	                enabled: false
	            }
	        }
	        ]
	    });
		
		chart.redraw();
	};
	
	form.load = function() {
		$.get('/chart/load')
		.fail(function(messages) {
			alert('fail');
		})
		.done(function(data) {
			burndown = data;
			form.renderChart(burndown);
		});
	};
	
	form.submit = function(e) {
		e.preventDefault();
		
		var tasksday = {
			'id':             0,
			'dayNumber':      $('#day-number').val(),
			'remainingTasks': $('#remaining-tasks').val(),
			'burndown':       {'id': burndown.id}
		}
		
		jQuery.ajax({
			type: 'POST',
			url: '/chart/send',
			contentType: 'application/json',
			data: JSON.stringify(tasksday),
			dataType: 'json',
			success: function(data) {
				burndown = data;
				form.renderChart(burndown);
			}
		});
	};
	
	form.iterateNumber = function(number, initialIndex){
		var iterate = new Array();
		
		for(var i = initialIndex; i <= number; i++){
			iterate.push(i);
		}
		
		return iterate;
	};
	
	form.generateGoalTasksPerDay = function(x, tasks){
		var goal = new Array(),
	    goalPerDay = tasks / (x.length -1),
	    yGoal = tasks;
	
		for (var i = 0; i < x.length; i++) {
			goal.push([x[i], yGoal]);
			yGoal -= goalPerDay; 
		}
		
		return goal;
	};
	
	form.getRemainingTasks = function(tasks){
		var remainingTasks = new Array();
		
		for (var i = 0; i < tasks.length; i++) {
			remainingTasks.push([tasks[i].dayNumber, tasks[i].remainingTasks]);
		}
		
		return remainingTasks;
	}
	
	$(document)
		.on('ready', form.init)
		.on('submit', '#frmSend', form.submit)
	;
	
	return form;
	
})();
