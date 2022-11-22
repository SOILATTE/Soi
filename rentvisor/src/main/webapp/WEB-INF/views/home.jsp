<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 스프링 MVC : 홈 뷰 -->

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<div class="slider">
	<div><img class ="slider_image" src="/images/image_slide_tent.jpg" /></div>
	<div><img class ="slider_image" src="/images/image_slide_hiking.jpg" /></div>
	<div><img class ="slider_image" src="/images/image_slide_camera.jpg" /></div>
	<div><img class ="slider_image" src="/images/image_slide_boardgame.jpg" /></div>
	<div><img class ="slider_image" src="/images/image_slide_waterslide.jpg" /></div>
</div>


<br>

<div class="introduction">
    <img class="introduction_image" src="/images/image_site_introduction.jpg">
    <img class="introduction_image" src="/images/image_site_introduction02.jpg">
    <img class="introduction_image" src="/images/image_site_introduction03.jpg">
</div>

<script>
  $(document).ready(function(){
    $('.slider').bxSlider();
  });
</script>