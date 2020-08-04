
var studentId;
function saveStudent(){
    var studentName=$("#studentName").val();
    var studentRollNo=$("#studentRollNo").val();
    $.ajax({
        type:"post",
        url:"StudentController",
        data:{
            action:"add",
            studentName:studentName,
            studentRollNo:studentRollNo
        },
        success:function(data){
            if(studentName=="" && studentRollNo==""){
                alert("Fill all the fields");
            }
            else{
                alert("Working");
            }
        }
    });
}
function showData() {
  //  $("#submitBtn").val("Add New Faculty");
    $.ajax({
        url: "StudentController",
        method: "POST",
        async: false,
        data: {
            action: "view"
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].facultyName + "</td>";
                html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].facultyId + ");'><i class='fas fa-pencil-alt'></i></a>";
                html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].facultyId + ");'><i class='fas fa-trash'></i></a>";
                html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}
$(document).ready(function(){
    $('#submitBtn1').click(function(){
        saveStudent();
    })
})