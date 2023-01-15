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
  <!-- Styles -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />
  <!-- Or for RTL support -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.rtl.min.css" />

  <!-- Scripts -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>
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
                        <i class="mdi mdi mdi-pine-tree menu-icon"style="margin-right: 5px;"></i> Add new plants</h2>
                    <form class="forms-sample"  action="/app/plant/save" method=post enctype="multipart/form-data">
                      <div class="form-group">
                        <label for="exampleInputName1">Name</label>
                        <input type="text" class="form-control" name="name" id="exampleInputName1" placeholder="Name" value="${plant.name}" required/>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputName1">Price</label>
                        <input type="text" class="form-control" name="price" id="exampleInputName1" placeholder="Example: 12.520" value="${plant.price}" required/>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputName1">Quantity</label>
                        <input type="text" class="form-control" name="quantity" id="exampleInputName1" placeholder="Example: 420" value="${plant.quantity}" required/>
                      </div>
                      <div class="form-group">
                        <label for="exampleSelectGender">Category</label>
                          <select class="form-select" id="multiple-select-field" data-placeholder="Select Categories" multiple name="categories">
		                      <c:forEach items="${category}" var="cc">
		                        <option value=${cc.id} <c:forEach items="${plant.categories}" var="pc">
		                           <c:if test="${pc.id==cc.id}">selected="true"</c:if>
		                        </c:forEach>>${cc.name} </option>
		                      </c:forEach>
		                  </select>
                        </div>
                        <div class="form-group">
                          <label for="exampleTextarea1">Description</label>
                          <textarea class="form-control" id="exampleTextarea1" name="description" rows="4" style="background-color: #efefef;" required>${plant.description}</textarea>
                        </div>
                      <div class="form-group">
                        <label>Main photo <span style="color: red;">*</span></label>
                        <input type="file" name="mainPhoto" class="file-upload-default" accept="image/png,image/jpeg" >
                        <div class="input-group col-xs-12">
                          <input type=hidden name="photo1" value="${plant.photos.photo1}">
                          <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image" value="${plant.photos.photo1}">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-warning" type="button">Upload</button>
                          </span>
                        </div>
                      </div>
                      <div class="form-group">
                        <label>Extra photos</label>
                        <p class="card-description">
                            3 extra photos maximum .
                          </p>
                        <input type="file" name="extraImages" id="extraImage"class="file-upload-default" accept="image/png,image/jpeg" multiple @change="trySubmitFile">
                        <div class="input-group col-xs-12">
                          <c:if test="${plant.photos.photo2!=null}">
                            <input type=hidden name="photo2" value="${plant.photos.photo2}">
                          </c:if>
                          <c:if test="${plant.photos.photo3!=null}">
                            <input type=hidden name="photo3" value="${plant.photos.photo3}">
                          </c:if>
                          <c:if test="${plant.photos.photo4!=null}">
                            <input type=hidden name="photo4" value="${plant.photos.photo4}">
                          </c:if>
                          <input type="text" class="form-control file-upload-info" id="imagesText" disabled placeholder="Upload Image" value="${plant.photos.photo2}${plant.photos.photo3}${plant.photos.photo4}">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-warning" type="button">Upload</button>
                          </span>
                        </div>
                      </div>
                      <input type=hidden name=id value="${plant.id}">
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
   <script >
 $( '#multiple-select-field' ).select2( {
	    theme: "bootstrap-5",
	    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
	    placeholder: $( this ).data( 'placeholder' ),
	    closeOnSelect: false,
	} );
 </script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>
  
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
