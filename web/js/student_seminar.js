/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showStudentSeminarRecords() {
    var studentId = $("#studentSessionId").val();
    alert(studentId);
    $.ajax({
        url: "SeminarGroupController",
        method: "POST",
        async: false,
        data: {
            action: "showStudentSeminarRecords",
            studentId : studentId
        },
        success: function (data) {
            var data = JSON.parse(data);
            alert(data[0].studentFeesId);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].seminar.seminarTitle + "</td>";
                html += "<td >" + data[i].thesis.thesisTitle + "</td>";
                html += "<td >" + data[i].dateApplied + "</td>";
                html += "<td >" + data[i].dateConducted + "</td>";
                html += "<td >" + data[i].remarks + "</td>";
                html += "<td >" + data[i].comments + "</td>";
                html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].feesId + ");'><i class='fas fa-pencil-alt'></i></a>";
                html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].feesId + ");'><i class='fas fa-trash'></i></a>";
                html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}

$(document).ready( function() {
    showStudentSeminarRecords();
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false
        });
    });
});