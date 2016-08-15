<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Simple Sprint Burndown</title>
    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    
    <script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
</head>
<body >
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>	

	<script>
		$(function () {
		    $('#container').highcharts({
		        credits: {
		      		enabled: false
		  		},
	  			xAxis: {
		            min: 0,
		            max: 10,
		            title: {
		                text: 'Days'
	            	}
		        },
		        exporting: { 
		        	enabled: false 
		        },
		        yAxis: {
		            min: 0,
		            max: 5,
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
		            data: [[0, 5], [1, 4.5], [2, 4], [3, 3.5], [4, 3], [5, 2.5], [6, 2], [7, 1.5], [8, 1], [9, 0.5], [10, 0]],           
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
		            name: 'Dead tasks',
		            data: [5, 3, 4, 1, 2, 2],
		            marker: {
		                radius: 5
		            }
		        },
		        
		        {
		            type: 'line',
		            name: 'Unplanned tasks',
		            data: [2, 2],
		            marker: {
		                radius: 5
		            }
		        }
		        ]
		    });
		});
	</script>
</html>