<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="${sideMenu}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="mainPageMargin">
    <div id="Layer1" align="left">
        <p align="center" class="a2"><font color="#000000"><b><font face="Arial, Helvetica, sans-serif">Reports</font></b></font></p>

        <p style="color: #000000"><font face="Arial, Helvetica, sans-serif">Select a report</font>
        </p>


        <table width="781" border="1">
            <tr>
                <td>Category</td>
                <td>Report</td>
                <td>Explanation</td>
            </tr>


            <%-- Basic Reports --%>
            <tr>
                <td colspan="3">Basic Reports</td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <font face="Arial, Helvetica, sans-serif"/>
                    <a href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=12&state=showReport">User
                        names and passwords</a>
                </td>
                <td>
                    <font  face="Arial, Helvetica, sans-serif"/> User names and passwords for this class
                </td>
            </tr>


            <%-- Learning Hut Reports --%>
            <tr>
                <td colspan="3"><font  face="Arial, Helvetica, sans-serif">Learning Hut Reports</font>
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=23&state=showReport">Class
                    Summary Per Student Per Topic</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Mastery levels of topics</td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=4&state=showReport">Class
                    Summary Per Problem</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Problems that are challenging for your
                    students
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=5&state=showReport">Class
                    Summary Per Student</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Number of problems and hints each student
                    has seen
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=2&state=showReport">Class
                    Summary Per Skill <br/> (will take a couple of minutes to run) </a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Math skills that your students are having
                    trouble with
                </td>
            </tr>
            <%-- For Researchers only Reports --%>
            <tr>
                <td colspan="3"><font  face="Arial, Helvetica, sans-serif">For Researchers only</font>
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=16&state=showReport">Class
                    Emotion Summary Per Student Per Emotion </a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Emotion summary per student per emotion
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=13&state=showReport">Detailed
                    Activity of each student</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>What students have worked on at each time
                    step
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=27&state=showReport">Collaboration
                    Activity in Simultaneous Problems</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Students Who Have Collaborated in
                    Simultaneous Problems
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=14&state=showReport">Start
                    and Stop times of Students with associated sensors</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>What students have worked on at each time
                    step
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=17&state=showReport">Impact
                    of Interventions</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>What students have worked on at each time
                    step
                </td>
            </tr>
            <tr>
                <td></td>
                <td ><font face="Arial, Helvetica, sans-serif"/><a
                        href="WoAdmin?action=AdminViewReport&teacherId=<c:out value="${teacherId}"/>&classId=<c:out value="${classId}"/>&reportId=19&state=showReport">Student
                    activity in learning hut.</a></td>
                <td><font  face="Arial, Helvetica, sans-serif"/>Detailed activity report of learning hut
                    activity- per student
                </td>
            </tr>

        </table>


    </div>
</div>


</body>
</html>
