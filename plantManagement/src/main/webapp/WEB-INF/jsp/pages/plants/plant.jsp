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
            <div class="col-md-12">
              <div class="card" style="display: flex;flex-direction: row; justify-content: space-between; padding-top: 50px;padding-bottom: 50px;padding-left: 50px;padding-right: 50px;">
                <div >
                  <h2 style="margin-bottom: 40px;">Plant's Details</h2>
                    <div class="form-group">
                      <h4 for="exampleInputUsername1">Name</h4>
                      <p class="card-description">
                        ${plant.name}
                      </p>
                    </div>
                    <div class="form-group">
                      <h4 for="exampleInputUsername1">Description</h4>
                      <p class="card-description">
                        ${plant.description}
                      </p>
                    </div>
                    <div class="form-group">
                      <h4 for="exampleInputUsername1">Price</h4>
                      <p class="card-description">
                        ${plant.price} DT
                      </p>
                    </div>
                    <div class="form-group">
                      <h4 for="exampleInputUsername1">Quantity</h4>
                      <p class="card-description">
                        ${plant.quantity}
                      </p>
                    </div>
                </div>
                <div >
                  <div style="display: flex;align-items: center;justify-content: center;flex-direction: column;">
                    <img style="width: 60% ;margin-bottom: 15px;" src="/../ProjectSpringImages/${plant.photos.photo1}"  alt="image"/>
                    <div>
                      <c:if test="${plant.photos.photo2!=null}">
                        <img style="width: 200px;height: 130px;" src="/../ProjectSpringImages/${plant.photos.photo2}"  alt="image"/>	
                      </c:if>	
                      <c:if test="${plant.photos.photo3!=null}">
                        <img style="width: 200px;height: 130px;" src="/../ProjectSpringImages/${plant.photos.photo3}"  alt="image"/>
                      </c:if>	
                      <c:if test="${plant.photos.photo4!=null}">
                        <img style="width: 200px;height: 130px;" src="/../ProjectSpringImages/${plant.photos.photo4}"  alt="image"/>	
                      </c:if>	
                      
                      
                    </div>
                  </div>
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
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
