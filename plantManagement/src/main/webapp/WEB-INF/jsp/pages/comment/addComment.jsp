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
                        <i class="mdi mdi mdi-grid-large menu-icon"style="margin-right: 5px;"></i> Add new comment</h2>
                    <form class="forms-sample"  action="/app/comment/save" method="post">
                      <div class="form-group">
                        <label for="exampleSelectGender">Admins</label>
                        <select class="form-control" name="admin" id="exampleSelectGender" required> 
                          <option>Select</option>
                          <c:forEach items="${listAdmin}" var="admin">
                            <option value=${admin.id} <c:if test="${comment.admin.id==admin.id}">selected="true"</c:if>>${admin.name} ${admin.lastName}</option>
                          </c:forEach>
                        </select>
                      </div>
                      <div class="form-group">
                        <label for="exampleSelectGender">Plants</label>
                          <select class="form-control" name="plant" id="exampleSelectGender" required> 
                            <option>Select</option>
                            <c:forEach items="${listPlant}" var="plant">
                              <option value=${plant.id} <c:if test="${comment.plant.id==plant.id}">selected="true"</c:if>>${plant.name}</option>
                            </c:forEach>
                          </select>
                      </div>
                      <div class="form-group">
                        <label for="exampleTextarea1">Comment</label>
                        <textarea class="form-control" id="exampleTextarea1" name="text" rows="4" style="background-color: #efefef;" required>${comment.text}</textarea>
                      </div>
                      <input type=hidden name=id value="${comment.id}">
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
  <script>
    const input = document.querySelector('#extraImage');
    const imagesText = document.getElementById('imagesText');
    
    // Listen for files selection
    input.addEventListener('change', (e) => {
        // Retrieve all files
        const files = input.files;

        // Check files count
        if (files.length > 3) {
            alert(`Only 3 photos are allowed to upload.`);
            console.log(input.value)
            return;
        }     
});

 </script>
  <script src="${pageContext.request.contextPath}/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/js/file-upload.js"></script>


  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
