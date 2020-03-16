const request = new XMLHttpRequest();
request.open('GET', '/demo/emp_no?emp_no=10002');

request.send();
request.onload = () => {
    if (request.status === 200) {
        console.log("Success"); // So extract data from json and create table

        //Extracting data
        var emp_no = JSON.parse(request.response).emp_no;
        var first_name = JSON.parse(request.response).first_name;

        //Creating table
        var table="<table>";
        table+="<tr><td>Employee No</td><td>First Name</td></tr>";
        table+="<tr><td>"+emp_no+"</td><td>"+first_name+"</td></tr>";
        table+="</table>";

        //Showing the table inside table
        document.getElementById("mydiv").innerHTML = table;
    }
};

request.onerror = () => {
    console.log("error")
};