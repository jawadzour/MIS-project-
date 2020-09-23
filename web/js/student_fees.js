/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showStudentFeeRecords() {
    var studentId = $("#studentSessionId").val();
    $.ajax({
        url: "FeesController",
        method: "POST",
        async: false,
        data: {
            action: "showStudentFeeRecords",
            studentId : studentId
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].fees.feesTitle + "</td>";
                html += "<td >" + data[i].fees.amount + "</td>";
                html += "<td >" + data[i].fees.announcementDate + "</td>";
                html += "<td >" + data[i].fees.dueDate + "</td>";
                html += "<td >" + data[i].datePaid + "</td>";
                html += "<td >" + data[i].amountPaid + "</td>";
                html += "<td >" + data[i].lateFees + "</td>";
                html += "<td >" + data[i].challanNumber + "</td>";
                //html += "<td >No Image</td>";
                //html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                //html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].feesId + ");'><i class='fas fa-pencil-alt'></i></a>";
                //html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].feesId + ");'><i class='fas fa-trash'></i></a>";
                //html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}

$(document).ready( function() {
    showStudentFeeRecords();
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false
        });
    });
});
