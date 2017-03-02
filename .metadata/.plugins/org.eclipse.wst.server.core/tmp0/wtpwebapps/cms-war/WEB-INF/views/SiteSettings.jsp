<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- start: PAGE CONTENT -->
<script>
	var _validFileExtensions = [ ".jpg", ".jpeg", ".bmp", ".gif", ".png" ];
	function Validate(oForm) {
		var arrInputs = oForm.getElementsByTagName("input");
		for (var i = 0; i < arrInputs.length; i++) {
			var oInput = arrInputs[i];
			if (oInput.type == "file") {
				var sFileName = oInput.value;
				if (sFileName.length > 0) {
					var blnValid = false;
					for (var j = 0; j < _validFileExtensions.length; j++) {
						var sCurExtension = _validFileExtensions[j];
						if (sFileName.substr(
								sFileName.length - sCurExtension.length,
								sCurExtension.length).toLowerCase() == sCurExtension
								.toLowerCase()) {
							blnValid = true;
							break;
						}
					}

					if (!blnValid) {
						alert("Sorry, " + sFileName
								+ " is invalid, allowed extensions are: "
								+ _validFileExtensions.join(", "));
						return false;
					}
				}
			}
		}

		return true;
	}
</script>
<div class="row">
	<div class="col-md-12">
		<!-- start: FORM VALIDATION 2 PANEL -->
		<div class="panel panel-white">
			<div class="panel-heading">
				<div class="panel-tools">
					<div class="dropdown">
						<a data-toggle="dropdown"
							class="btn btn-xs dropdown-toggle btn-transparent-grey"> <i
							class="fa fa-cog"></i>
						</a>
						<ul class="dropdown-menu dropdown-light pull-right" role="menu">
							<li><a class="panel-collapse collapses" href="#"><i
									class="fa fa-angle-up"></i> <span>Collapse</span> </a></li>
							<li><a class="panel-refresh" href="#"> <i
									class="fa fa-refresh"></i> <span>Refresh</span>
							</a></li>
							<li><a class="panel-config" href="#panel-config"
								data-toggle="modal"> <i class="fa fa-wrench"></i> <span>Configurations</span>
							</a></li>
							<li><a class="panel-expand" href="#"> <i
									class="fa fa-expand"></i> <span>Full screen</span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<h2>
					<i class="fa fa-pencil-square"></i> Site Settings
				</h2>

				<hr>
				<form enctype="multipart/form-data" method="post"
					onsubmit="return Validate(this);">
					<c:if test="${failureError ne null }">
						<div style="color: red;">Something went wrong:
							${failureError}</div>
					</c:if>
					<div class="row">
						<div class="col-md-12">
							<div class="errorHandler alert alert-danger no-display">
								<i class="fa fa-times-sign"></i> You have some form errors.
								Please check below.
							</div>
							<div class="successHandler alert alert-success no-display">
								<i class="fa fa-ok"></i> Your form validation is successful!
							</div>
						</div>
						<div class="col-md-12">
							<div>
								<input type="hidden" name="siteId" value="${site.siteId}" />
							</div>
							<div class="form-group">
								<label class="control-label"> Web site name <span
									class="symbol required"></span>
								</label> <input type="text" disabled class="form-control" id="siteName"
									name="siteName" value="${site.siteName}" disabled>
							</div>
							<div class="form-group">
								<label class="control-label"> Delivery site URL <span
									class="symbol required"></span>
								</label> <input type="text" disabled class="form-control" id="siteUrl"
									name="siteUrl" value="${site.siteUrl}" disabled>
							</div>
							<div class="form-group">
								<label class="control-label"> Site Logo <span
									class="symbol required"></span>
								</label> <input type="file" class="form-control" id="siteLogo"
									name="siteLogo">
							</div>

						</div>

					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<button name="upload" value="upload"
								class="btn btn-yellow btn-block" type="submit">
								Save <i class="fa fa-arrow-circle-right"></i>
							</button>
						</div>
						<div class="col-md-4"></div>
					</div>
				</form>
			</div>
		</div>
		<!-- end: FORM VALIDATION 2 PANEL -->
	</div>
</div>
<!-- end: PAGE CONTENT-->