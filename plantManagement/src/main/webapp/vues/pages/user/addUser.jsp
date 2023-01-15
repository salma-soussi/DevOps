<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Majestic Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png" />

  
</head>

<body>

  <div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <%@ include file="../../partials/_navbar.html" %>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_sidebar.html -->
      <%@ include file="../../partials/_sidebar.html" %>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h2 style="display:flex; align-items:center; margin-bottom: 30px;">
                        <i class="mdi mdi mdi-account menu-icon"style="margin-right: 5px;"></i> Add new user</h2>
                    <form class="forms-sample"  action="/app/user/save" method=post enctype="multipart/form-data">
                      <div class="form-group">
                        <label for="exampleInputName1">First name</label>
                        <input type="text" class="form-control" name="name" id="exampleInputName1" placeholder="First name" value="${user.name}" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputName1">Last name</label>
                        <input type="text" class="form-control" name="lastName" id="exampleInputName1" placeholder="Last name" value="${user.lastName}" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputName1">Email</label>
                        <input type="email" class="form-control" name="email" id="exampleInputName1" placeholder="Email" value="${user.email}" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputName1">Password</label>
                        <input type="password" class="form-control" name="password" id="exampleInputName1" placeholder="Password" value="${user.password}" required>
                      </div>
                      <div class="form-group">  
                        <label>Profile photo <span style="color: red;">*</span></label>
                        <input type="file" name="photo1" class="file-upload-default" accept="image/png,image/jpeg" >
                        <div class="input-group col-xs-12">
                          <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image" >
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-warning" type="button">Upload</button>
                          </span>
                        </div>
                      </div>
                      <p class="card-description">
                        Address
                      </p>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Num</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" placeholder="House's number" name="num" value="${address.num}"/>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Street</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" placeholder="Street's name" name="rue" value="${address.rue}"/>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-6">
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label">City</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" placeholder="City" name="ville" value="${address.ville}"/>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Postcode</label>
                            <div class="col-sm-9">
                              <input type="text" class="form-control" placeholder="Example: 5012" name="codePostal" value="${address.codePostal}"/>
                            </div>
                          </div>
                        </div>
                      </div>
                      <input type=hidden name="photo" value="${user.photo}">
                      <input type=hidden name=id value="${user.id}">
                      <button type="submit" class="btn btn-success me-2">Submit</button>
                      <button type="reset" class="btn btn-light">Cancel</button>
                    </form>
                  </div>
                </div>
              </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->

          <%@ include file="../../partials/_footer.html" %>

        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/js/file-upload.js"></script>


  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
