

  $(function () {
    
    var areaChartCanvas = $('#areaChart').get(0).getContext('2d');

    var areaChartData = {
      labels  : ['Gender'],
      datasets: [
        {
          label               : 'Male',
          backgroundColor     : 'rgba(60,141,188,0.9)',
          borderColor         : 'rgba(60,141,188,0.8)',
          pointRadius          : false,
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [28]
          
        },
        {
          label               : 'Female',
          backgroundColor     : 'rgba(210, 214, 222, 1)',
          borderColor         : 'rgba(210, 214, 222, 1)',
          pointRadius         : false,
          pointColor          : 'rgba(210, 214, 222, 1)',
          pointStrokeColor    : '#c1c7d1',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(220,220,220,1)',
          data                : [78]
        }
      ]
    };

    var areaChartOptions = {
      maintainAspectRatio : false,
      responsive : true,
      legend: {
        display: true
      },
      scales: {
        xAxes: [{
          gridLines : {
            display : true
          }
          
        }],
        yAxes: [{
          gridLines : {
            display : true
          }
        }]
      }
    };

    // This will get the first returned node in the jQuery collection.
    var areaChart       = new Chart(areaChartCanvas, { 
      type: 'bar',
      data: areaChartData, 
      options: areaChartOptions
    });
    //-------------
    //- LINE CHART -
    //--------------
    var donutChartCanvas = $('#donutChart').get(0).getContext('2d');
    var donutData= {
      labels: [
          'Paid', 
          'Late'
      ],
      datasets: [
        {
          data: [70,20],
          backgroundColor : ['#f56954', '#00a65a']
        }
      ]
    };
    var donutOptions     = {
      maintainAspectRatio : false,
      responsive : true
    };
    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    var donutChart = new Chart(donutChartCanvas, {
      type: 'doughnut',
      data: donutData,
      options: donutOptions      
    });

    var areaChartData1 = {
      labels  : ['Student Thesis Submission'],
      datasets: [
        {
          label               : 'Accepted',
          backgroundColor     : 'rgba(60,141,188,0.9)',
          borderColor         : 'rgba(60,141,188,0.8)',
          pointRadius          : false,
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [70]
          
        },
        {
          label               : 'Rejected',
          backgroundColor     : 'rgba(210, 214, 222, 1)',
          borderColor         : 'rgba(210, 214, 222, 1)',
          pointRadius         : false,
          pointColor          : 'rgba(210, 214, 222, 1)',
          pointStrokeColor    : '#c1c7d1',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(220,220,220,1)',
          data                : [28]
        }
      ]
    };
     var barChartCanvas = $('#barChart').get(0).getContext('2d');
    var barChartData = jQuery.extend(true, {}, areaChartData1);
    var temp0 = areaChartData1.datasets[0];
    var temp1 = areaChartData1.datasets[1];
    barChartData.datasets[0] = temp1;
    barChartData.datasets[1] = temp0;

    var barChartOptions = {
      responsive              : true,
      maintainAspectRatio     : false,
      datasetFill             : false
    };

    var barChart = new Chart(barChartCanvas, {
      type: 'bar', 
      data: barChartData,
      options: barChartOptions
    });


  });