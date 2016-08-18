var BurndownForm = (function(){
	
	var form            = {},
		burndownList    = [{}],
		burndown        = {};
	
	form.init = function() {
		form.list();
	};
	
	form.list = function() {
		$.get('/burndown/list')
		.fail(function(messages) {
			alert('fail');
		})
		.done(function(data) {
			burndownList = data;
			form.renderTable(burndownList);
		});
	};
	
	form.renderTable = function(list){
		var tbody = document.createElement("tbody");
		for (var i = 0; i < list.length; i++) {
			var tr = document.createElement("tr");
			tr.appendChild(form.createTd(list[i].name));
			tr.appendChild(form.createTd(list[i].start));
			tr.appendChild(form.createTd(list[i].end));
			tr.appendChild(form.createTd(list[i].numberTasks));
			tr.appendChild(form.createTdWithIcons());
			
			tbody.appendChild(tr);
		}
		
		document.getElementById("table-burndown").appendChild(tbody);
	};
	
	form.createElement = function(element, nameClass){
		var icon = document.createElement(element);
		if (nameClass)
			icon.className = nameClass;
		
		return icon;
	}
	
	form.createTdWithIcons = function(){
		var td, div, icon;
		
		td = form.createTd();
		div = form.createElement('div', 'col-md-6');
		icon = form.createElement('i', 'glyphicon glyphicon-trash');
		div.appendChild(icon);
		td.appendChild(div);

		div = form.createElement('div', 'col-md-6');
		icon = form.createElement('i', 'glyphicon glyphicon-edit');
		div.appendChild(icon);
		td.appendChild(div);
		
		return td;
	}
	
	form.createTd = function(content){
		var td = document.createElement("td");
		td.align = "center";
		if (content) {
			var cellText = document.createTextNode(content);
			td.appendChild(cellText);
		}
		return td;
	};
	
	form.submit = function(e) {
		e.preventDefault();
		
		
		
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
	
	$(document)
		.on('ready', form.init)
		.on('submit', '#frmSend', form.submit)
	;
	
	return form;
	
})();
