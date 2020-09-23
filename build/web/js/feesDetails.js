/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var studentFeesId;
function saveStudentFees() {
    var studentRollNumber = $("#inputStudentRollNumber").val();
    var feesId = $("#inputFees").val();
    var datePaid = $("#inputDatePaid").val();
    var amountPaid = $("#inputAmountPaid").val();
    var lateFee = $("#inputLateFee").val();
    var challanNumber = $("#inputChallanNumber").val();
    $.ajax({
        type: "POST",
        url: "FeesDetailsController",
        data: {
            action: "add",
            studentRollNumber: studentRollNumber,
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
                html += "<tr><td >" + data[i].student.rollNumber + "</td>";
                html += "<td >" + data[i].fees.feesTitle + "</td>";
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
            $("#inputStudentRollNumber").val(data.student.rollNumber);
            $("#inputFees").val(data.fees.feesId);
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
    var studentRollNumber = $("#inputStudentRollNumber").val();
    var feesId = $("#inputFees").val();
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
            studentRollNumber: studentRollNumber,
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
function populateFeesTitles() {
    $.ajax({
        type: "POST",
        url: "FeesController",
        data: {
            action: "view"
        },
        success: function (data, textStatus, jqXHR) {
            var data = JSON.parse(data);
            var html = "<option value='' selected disabled>Select Fees Title</option>";
            for (var i = 0; i < data.length; i++) {
                html += "<option value='" + data[i].feesId + "'>" + data[i].feesTitle + "</option>";
            }
            $("#inputFees").html(html);
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
    populateFeesTitles();
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
                required: "Please Enter Student Roll Number"
            },
            feesId: {
                required: "Please Select Fees"
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
