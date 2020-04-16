let chartDataStr = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartDataStr);
let arrayLength = chartJsonArray.length;
let numericData = [];
let labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#FF0009", "#00FF20", "#FFFC90", "#3E20FF"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Projects Status'
        }
    }
});

function decodeHtml(html) {
    let areaElement = document.createElement("textarea");
    areaElement.innerHTML = html;

    return areaElement.value;
}
