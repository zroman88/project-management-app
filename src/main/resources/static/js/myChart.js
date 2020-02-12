new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#FF0009", "#00FF20", "#FFFC90", "#3E20FF"],
            borderColor: 'rgb(255, 99, 132)',
            data: [10, 5, 2, 20, 30, 45]
        }]
    },

    // Configuration options go here
    options: {}
});
