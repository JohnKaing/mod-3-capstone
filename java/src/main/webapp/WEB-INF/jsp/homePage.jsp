<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
    
<!DOCTYPE html>
<html>

<body>

<section class="parks">
    <h1>Cuyahoga Valley National Park</h1>
    <section class="park">
        <c:url var="cvnpImgSrc" value="/img/parks/cvnp.jpg" />
		<img src="${cvnpImgSrc}" alt="cvnppark">
		<p>Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal.</p>
    </section>

    <h1>Everglades National Park</h1>
    <section class="park">
        <c:url var="enpImgSrc" value="/img/parks/enp.jpg" />
		<img src="${enpImgSrc}" alt="enppark">
<p>There are no other Everglades in the world. They are, they have always been, one of the unique regions of the earth; remote, never wholly known. Nothing anywhere else is like them.</p>
	</section>

<h1>Glacier National Park</h1>
  <section class="park">
        <c:url var="gnpImgSrc" value="/img/parks/gnp.jpg" />
        <img src="${gnpImgSrc}" alt="gnppark">
        <p>It is the one great wonders. . . every American should see.</p>   
</section>

<h1>Grand Canyon National Park</h1>
  <section class="park">
        <c:url var="gcnpImgSrc" value="/img/parks/gcnp.jpg" />
        <img src="${gcnpImgSrc}" alt="gcnppark">
        <p>Far away in northwestern Montana, hidden from view by clustering mountain peaks, lies an unmapped corner—the Crown of the Continent.</p>   
</section>

<h1>Grand Teton National Park</h1>
  <section class="park">
        <c:url var="gtnpImgSrc" value="/img/parks/gtnp.jpg" />
        <img src="${gtnpImgSrc}" alt="gtnppark">
        <p>May your trails be crooked, winding, lonesome, dangerous, leading to the most amazing view. May your mountains rise into and above the clouds.</p>   
</section>

<h1>Great Smoky Mountain National Park</h1>
  <section class="park">
        <c:url var="gsmnpImgSrc" value="/img/parks/gsmnp.jpg" />
        <img src="${gsmnpImgSrc}" alt="gsmnppark">
        <p>We can not have freedom without wilderness.</p>   
</section>

<h1>Mount Rainier National Park</h1>
  <section class="park">
        <c:url var="mrnpImgSrc" value="/img/parks/mrnp.jpg" />
        <img src="${mrnpImgSrc}" alt="mrnppark">
        <p>Of all the fire mountains which like beacons, once blazed along the Pacific Coast, Mount Rainier is the noblest.</p>   
</section>

<h1>Rocky Mountain National Park</h1>
  <section class="park">
        <c:url var="rmnpImgSrc" value="/img/parks/rmnp.jpg" />
        <img src="${rmnpImgSrc}" alt="rmnppark">
        <p>It's not the mountain we conquer, but ourselves.</p>   
</section>

<h1>Yellowstone National Park</h1>
  <section class="park">
        <c:url var="ynpImgSrc" value="/img/parks/ynp.jpg" />
        <img src="${ynpImgSrc}" alt="ynppark">
        <p>Yellowstone Park is no more representative of America than is Disneyland.</p>   
</section>

<h1>Yosemite National Park</h1>
  <section class="park">
        <c:url var="ynp2ImgSrc" value="/img/parks/ynp2.jpg" />
        <img src="${ynp2ImgSrc}" alt="ynp2park">
        <p>Yosemite Valley, to me, is always a sunrise, a glitter of green and golden wonder in a vast edifice of stone and space.</p>   
</section>

 
</body>
</html>