/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var studentFeesId;
function saveStudentFees() {
    var studentId = $("#inputStudentId").val();
    var feesId = $("#inputFeesId").val();
    var datePaid = $("#inputDatePaid").val();
    var amountPaid = $("#inputAmountPaid").val();
    var lateFee = $("#inputLateFee").val();
    var challanNumber = $("#inputChallanNumber").val();
    $.ajax({
        type: "POST",
        url: "FeesDetailsController",
        data: {
            action: "add",
            studentId: studentId,
            feesId: feesId,
            datePaid: datePaid,
            amountPaid: amountPaid,
            lateFee: lateFee,
            challanNumber: challanNumber
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });

    //}

}
function showData() {
    $("#submitBtn").val("Add New Fee Detail");
    $.ajax({
        url: "FeesDetailsController",
        method: "POST",
        async: false,
        data: {
            action: "view"
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].student.studentId + "</td>";
                html += "<td >" + data[i].fees.feesId + "</td>";
                html += "<td >" + data[i].datePaid + "</td>";
                html += "<td >" + data[i].amountPaid + "</td>";
                html += "<td >" + data[i].lateFees + "</td>";
                html += "<td >" + data[i].challanNumber + "</td>";
                html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].studentFeesId + ");'><i class='fas fa-pencil-alt'></i></a>";
                html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].studentFeesId + ");'><i class='fas fa-trash'></i></a>";
                html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}
function getData(id) {
    studentFeesId = id;
    $.ajax({
        url: "FeesDetailsController",
        method: "POST",
        async: false,
        data: {
            action: "getStudentFeesRecord",
            studentFeesId: studentFeesId
        },
        success: function (data) {
            var data = JSON.parse(data);
            $("#inputStudentId").val(data.student.studentId);
            $("#inputFeesId").val(data.fees.feesId);
            $("#inputDatePaid").val(data.datePaid);
            $("#inputAmountPaid").val(data.amountPaid);
            $("#inputLateFee").val(data.lateFees);
            $("#inputChallanNumber").val(data.challanNumber);
            $("#submitBtn").val("Update Fee Detail");
            $("html").animate({scrollTop: 0}, "slow");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function updateData() {
    var studentId = $("#inputStudentId").val();
    var feesId = $("#inputFeesId").val();
    var datePaid = $("#inputDatePaid").val();
    var amountPaid = $("#inputAmountPaid").val();
    var lateFee = $("#inputLateFee").val();
    var challanNumber = $("#inputChallanNumber").val();
    var id = studentFeesId;
    $.ajax({
        type: "POST",
        url: "FeesDetailsController",
        data: {
            action: "update",
            studentId: studentId,
            feesId: feesId,
            datePaid: datePaid,
            amountPaid: amountPaid,
            lateFee: lateFee,
            challanNumber: challanNumber,
            studentFeesId: id
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            alert("Data Updated Successfully!");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function deleteData(id) {
    studentFeesId = id;
    $.ajax({
        type: "POST",
        url: "FeesDetailsController",
        data: {
            action: "delete",
            studentFeesId: studentFeesId
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            location.reload();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            alert("Data Deleted Successfully!");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}

function resetFields() {
    $("#inputStudentId").val('');
    $("#inputFeesId").val('');
    $("#inputDatePaid").val('');
    $("#inputAmountPaid").val('');
    $("#inputLateFee").val('');
    $("#inputChallanNumber").val('');
    showData();
}
$(document).ready(function () {
    showData();
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false
        });
    });
    $("#studentFeesForm").validate({
        rules: {
            studentId: {
                required: true
            },
            feesId: {
                required: true
            },
            datePaid: {
                required: true
            },
            amountPaid: {
                required: true
            },
            lateFee: {
                required: true
            },
            challanNumber: {
                required: true
            }

        },
        messages: {
            studentId: {
                required: "Please Enter Student ID"
            },
            feesId: {
                required: "Please Enter Fees ID"
            },
            datePaid: {
                required: "Please Select Date Paid"
            },
            amountPaid: {
                required: "Please Enter Amount Paid"
            },
            lateFee: {
                required: "Please Enter Late Fees"
            },
            challanNumber: {
                required: "Please Enter Challan Number"
            }
        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });

});
$("#submitBtn").on("click", function () {
    if ($("#studentFeesForm").valid()) {
        if ($("#submitBtn").val() === "Add New Fee Detail") {
            saveStudentFees();
        } else if ($("#submitBtn").val() === "Update Fee Detail") {
            updateData();
        }
    }
});
if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}
