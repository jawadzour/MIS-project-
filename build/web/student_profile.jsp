<%-- 
    Document   : student_profile
    Created on : Jul 31, 2020, 2:38:59 PM
    Author     : khatr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Management Information System</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <jsp:include page="head_links.jsp"/>
        <style>
            .fa-pencil-alt {
                color: white;
            }
            .fa-trash {
                color: white;
            }
        </style>
    </head>
    <body class="hold-transition sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <jsp:include page="navbar.jsp"/>
            <jsp:include page="top_navbar.jsp"/>
            

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Manage Faculties</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                    <li class="breadcrumb-item active">Department</li>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section> 
                <!-- Main content -->
                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">

                                <!-- Profile Image -->
                                <div class="card card-primary card-outline">
                                    <div class="card-body box-profile">
                                        <div class="text-center">
                                            <img class="profile-user-img img-fluid img-circle"
                                                 src="dist/img/user4-128x128.jpg"
                                                 alt="User profile picture"/>
                                        </div>

                                        <h3 class="profile-username text-center">Nina Mcintire</h3>

                                        <p class="text-muted text-center">Software Engineer</p>

                                    </div>
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->
                                <div class="card">
                                    <div class="card-header p-2">
                                        <ul class="nav nav-pills">
                                            <li class="nav-item"><a class="nav-link active" href="#information" data-toggle="tab">Information</a></li>
                                            <li class="nav-item"><a class="nav-link" href="#timeline" data-toggle="tab">Documents</a></li>
                                            <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Experience</a></li>
                                        </ul>
                                    </div><!-- /.card-header -->
                                    <div class="card-body">
                                        <div class="tab-content">
                                            <div class="active tab-pane" id="information">
                                                <div class="card card-primary">
                                                    <div class="card-header">
                                                        <h3 class="card-title">Personal Information</h3>

                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Roll Number</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFullName">Full Name</label>
                                                                    <input type="email" class="form-control" id="inputFullName" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFatherName">Father Name</label>
                                                                    <input type="email" class="form-control" id="inputFatherName" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputLegalId">Legal ID</label>
                                                                    <input type="email" class="form-control" id="inputLegalId" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputLegalIdNo">Legal ID Number</label>
                                                                    <input type="email" class="form-control" id="inputLegalIdNo" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputNationality">Nationality</label>
                                                                    <input type="email" class="form-control" id="inputNationality" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputPlaceOfIssueOfLegalId">Place Of Issue Of Legal ID</label>
                                                                    <input type="email" class="form-control" id="inputPlaceOfIssueOfLegalId" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputDateOfIssueOfLegalId">Date of Issue of Legal ID</label>
                                                                    <input type="email" class="form-control" id="inputDateOfIssueOfLegalId" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputMobileNumber">Mobile Number</label>
                                                                    <input type="email" class="form-control" id="inputMobileNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputDob">Date Of Birth</label>
                                                                    <input type="email" class="form-control" id="inputDob" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputEmail">Email</label>
                                                                    <input type="email" class="form-control" id="inputEmail" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputDomicile">Domicile</label>
                                                                    <input type="email" class="form-control" id="inputDomicile" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputCountryOfBirth">Country Of Birth</label>
                                                                    <input type="email" class="form-control" id="inputCountryOfBirth" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputBloodGroup">Blood Group</label>
                                                                    <input type="email" class="form-control" id="inputBloodGroup" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputReligion">Religion</label>
                                                                    <input type="email" class="form-control" id="inputReligion" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputAddress">Address</label>
                                                                    <input type="email" class="form-control" id="inputAddress" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputCurrentAddress">Current Address</label>
                                                                    <input type="email" class="form-control" id="inputCurrentAddress" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>    
                                                </div>

                                                <div class="card card-primary">
                                                    <div class="card-header">
                                                        <h3 class="card-title">Academic Information</h3>

                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Semester</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFullName">Deparment</label>
                                                                    <input type="email" class="form-control" id="inputFullName" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Batch</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFullName">Admission Date</label>
                                                                    <input type="email" class="form-control" id="inputFullName" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Supervisor</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFullName">Program</label>
                                                                    <input type="email" class="form-control" id="inputFullName" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Field Program</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputFullName">Shift</label>
                                                                    <input type="email" class="form-control" id="inputFullName" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputRollNumber">Timing</label>
                                                                    <input type="email" class="form-control" id="inputRollNumber" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div>
                                            <!-- /.tab-pane -->
                                            <div class="tab-pane" id="timeline">
                                                <div class="card card-primary">
                                                    <div class="card-header">
                                                        <h3 class="card-title">Matriculation</h3>

                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputPassingYear">Passing Year</label>
                                                                    <input type="email" class="form-control" id="inputPassingYear" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputBoard">Board</label>
                                                                    <input type="email" class="form-control" id="inputBoard" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputMarks">Marks Obtained</label>
                                                                    <input type="email" class="form-control" id="inputMarks" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputSubject">Subject</label>
                                                                    <input type="email" class="form-control" id="inputSubject" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Marksheet</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Certificate</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <input id="submitBtn" type="submit" value="Update" class="btn btn-success float-right" >
                                                            </div>
                                                        </div>
                                                    </div>    
                                                </div>
                                                <div class="card card-primary">
                                                    <div class="card-header">
                                                        <h3 class="card-title">Intermediate</h3>

                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputPassingYear">Passing Year</label>
                                                                    <input type="email" class="form-control" id="inputPassingYear" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputBoard">Board</label>
                                                                    <input type="email" class="form-control" id="inputBoard" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputMarks">Marks Obtained</label>
                                                                    <input type="email" class="form-control" id="inputMarks" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputSubject">Subject</label>
                                                                    <input type="email" class="form-control" id="inputSubject" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Marksheet</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Certificate</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <input id="submitBtn" type="submit" value="Update" class="btn btn-success float-right" >
                                                            </div>
                                                        </div>
                                                    </div>    
                                                </div>
                                                <div class="card card-primary">
                                                    <div class="card-header">
                                                        <h3 class="card-title">Graduate</h3>

                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputPassingYear">Passing Year</label>
                                                                    <input type="email" class="form-control" id="inputPassingYear" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputBoard">University</label>
                                                                    <input type="email" class="form-control" id="inputBoard" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputMarks">CGPA</label>
                                                                    <input type="email" class="form-control" id="inputMarks" placeholder="19ME-SW101">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="inputSubject">Degree Program</label>
                                                                    <input type="email" class="form-control" id="inputSubject" placeholder="Nand Lal">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Marksheet</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <label for="inputMarksheet">Certificate</label>
                                                                <img src="../../dist/img/user4-128x128.jpg" width="1000px" height="800px">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <input id="submitBtn" type="submit" value="Update" class="btn btn-success float-right" >
                                                            </div>
                                                        </div>
                                                    </div>    
                                                </div>
                                            </div>
                                            <!-- /.tab-pane -->

                                            <div class="tab-pane" id="settings">
                                                <form class="form-horizontal">
                                                    <div class="form-group row">
                                                        <label for="inputName" class="col-sm-2 col-form-label">Name</label>
                                                        <div class="col-sm-10">
                                                            <input type="email" class="form-control" id="inputName" placeholder="Name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                                        <div class="col-sm-10">
                                                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputName2" class="col-sm-2 col-form-label">Name</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputName2" placeholder="Name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputExperience" class="col-sm-2 col-form-label">Experience</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputSkills" class="col-sm-2 col-form-label">Skills</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="offset-sm-2 col-sm-10">
                                                            <div class="checkbox">
                                                                <label>
                                                                    <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="offset-sm-2 col-sm-10">
                                                            <button type="submit" class="btn btn-danger">Submit</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <!-- /.tab-pane -->
                                        </div>
                                        <!-- /.tab-content -->
                                    </div><!-- /.card-body -->
                                </div>
                                <!-- /.nav-tabs-custom -->


                            </div>
                            <!-- /.row -->
                        </div><!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->   
        </div>
        <!-- ./wrapper -->

        <jsp:include page="bottom_links.jsp"/>
        <!-- page script -->
        <script src="js/department.js"></script>
    </body>
</html>
