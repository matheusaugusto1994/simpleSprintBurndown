var BurndownForm = (function(){
	
	var form             = {},
		burndownList     = {},
		burndown         = {}
		;
	
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
			var tr = form.createElement('tr', undefined, 'tr-burndown');
			tr.dataset.id = list[i].id;
			
			tr.appendChild(form.createTd(list[i].name));
			tr.appendChild(form.createTd(list[i].start));
			tr.appendChild(form.createTd(list[i].end));
			tr.appendChild(form.createTd(list[i].numberTasks));
			tr.appendChild(form.createTdWithIcons());
			
			tbody.appendChild(tr);
		}
		
		document.getElementById("table-burndown").appendChild(tbody);
	};
	
	form.createElement = function(elementType, nameClass, id){
		var element = document.createElement(elementType);
		if (nameClass)
			element.className = nameClass;
		
		if (id)
			element.id = id;
		
		return element;
	}
	
	form.createTdWithIcons = function(){
		var td = form.createTd(), 
		    div, 
		    icon,
		    a;
		
		div = form.createElement('div', 'col-md-6');
		icon = form.createElement('i', 'glyphicon glyphicon-trash');
		a = form.createElement('a', undefined, 'a-delete');
		a.appendChild(icon);
		div.appendChild(a);
		td.appendChild(div);

		div = form.createElement('div', 'col-md-6');
		icon = form.createElement('i', 'glyphicon glyphicon-edit');
		a = form.createElement('a', undefined, 'a-update');
		a.appendChild(icon);
		div.appendChild(a);
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
		
//		
//		
//		jQuery.ajax({
//			type: 'POST',
//			url: '/chart/send',
//			contentType: 'application/json',
//			data: JSON.stringify(tasksday),
//			dataType: 'json',
//			success: function(data) {
//				burndown = data;
//				form.renderChart(burndown);
//			}
//		});
	};
	
	form.tdClick = function(){
		window.location.href = '/chart/' + this.dataset.id;
	}

	form.deleteBurndown = function(event){
		alert('click');
		event.stopPropagation();
	}

	form.updateBurndown = function(event){
		event.stopPropagation();
	}

	form.showElement = function(event){
		var element = $('#' + event.data.param1);
		element.show(event.data.param2);
	}

	form.hideElement = function(event){
		form.clearFields();
		var element = $('#' + event.data.param1);
		element.hide(event.data.param2);
	}
	
	form.clearFields = function(){
		$(':input').val('');
	}
	
	$(document)
		.on('ready', form.init)
		.on('submit', 'form-burndown', form.submit)
		.on('click', '#tr-burndown', form.tdClick)
		.on('click', '#a-delete', form.deleteBurndown)
		.on('click', '#a-update', form.updateBurndown)
		.on('click', '#bt-new-burndown', {param1: 'form-burndown', param2: 500}, form.showElement)
		.on('click', '#bt-cancel', {param1: 'form-burndown', param2: 500}, form.hideElement)
	;
	
	return form;
	
})();
