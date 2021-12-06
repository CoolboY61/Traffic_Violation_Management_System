<%--
  Created by IntelliJ IDEA.
  User: 30470
  Date: 2021/7/6
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style>
        /*css 初始化 */
        html, body, ul, li, ol, dl, dd, dt, p, h1, h2, h3, h4, h5, h6, form, fieldset, legend, img {
            margin: 0;
            padding: 0;
        }

        /*将标签原有的默认内外边距去掉*/

        fieldset, img, input, button {
            border: none; /*去掉边框*/
            padding: 0;
            margin: 0;
            outline-style: none; /*去掉环绕边框*/
        }

        ul, ol {
            list-style: none; /*去掉原样式中的小黑点*/
            /*ctrl+alt+l*/
        }

        input {
            padding-top: 0;
            padding-bottom: 0;

        }

        select, input {
            vertical-align: middle; /*输入字居中显示*/
        }

        select, input, textarea {
            font-size: 14px;
            margin: 0;
        }

        /**/
        textarea {
            resize: none; /*防止拖动*/
        }

        img {
            border: 0;
            vertical-align: middle; /*  去掉图片底部默认的3像素空白缝隙*/
        }

        table {
            border-collapse: collapse; /*合并外边线*/
        }

        body {
            font-family:  Microsoft YaHei, Arial, "\5b8b\4f53";
            background: #3690ea;
        }

        .clearfix:before, .clearfix:after {
            content: "";
            display: table;
        }

        .clearfix:after {
            clear: both;
        }

        .clearfix {
            *zoom: 1; /*IE/7/6*/
            /*兼容IE6下的写法*/
        }

        h1, h2, h3, h4, h5, h6 {
            text-decoration: none; /**/
            font-weight: normal; /*不加粗*/
            font-size: 100%;
        }

        /*login 开始*/
        .login{
            width: 1000px;
            height: 500px;
            /*background-color: yellowgreen;*/
            position: absolute;
            left:50%;
            top:50%;
            margin-left: -500px;
            margin-top: -250px;

            background: #3690ea;
        }
        .login>.login_title{
            height: 80px;
            text-align: center;
        }
        .login>.login_title>p{
            color:#fff;
            font-size: 40px;
            font-weight: 600;
            margin-top: -8px;
            letter-spacing:5px
        }
        .login>.login_main{
            width: 1000px;
            height: 320px;
            margin-top:20px;
        }
        .login>.login_main>.main_left{
            height: 320px;
            width: 650px;
            float: left;
            -moz-border-top-left-radius: 10px;
            -webkit-border-top-left-radius: 10px;
            border-top-left-radius: 10px;

            -moz-border-bottom-left-radius: 10px;
            -webkit-border-bottom-left-radius: 10px;
            border-bottom-left-radius: 10px;

            background: url("./images/login_left.png") no-repeat;
        }
        .login>.login_main>.main_right{
            position: relative;
            top: -21px;
            height: 320px;
            width: 350px;
            float: right;
            background-color: #e9eef2;
            -moz-border-top-right-radius: 10px;
            -webkit-border-top-right-radius: 10px;
            border-top-right-radius: 10px;

            -moz-border-bottom-right-radius: 10px;
            -webkit-border-bottom-right-radius: 10px;
            border-bottom-right-radius: 10px;
        }
        .login>.login_main>.main_right>.right_title{
            color:#251E5F;
            font-size: 20px;
            font-weight: 700;
            text-align: center;
            line-height: 60px;
            background: url("./images/border_img.png") repeat;
            margin-bottom: 25px;
        }
        .login>.login_main>.main_right>form>div{
            position: relative;
        }
        .login>.login_main>.main_right>form>div>img{
            position: absolute;
            left: 62px;
            top:7px;
        }
        .login>.login_main>.main_right>form input{
            height: 35px;
            width: 250px;
            border: 1px solid #d3d8dc;
            box-sizing: border-box;
            margin-bottom: 20px;
            margin-left: 50px;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            color:#333;
            padding-left: 40px;
        }

        .login>.login_main>.main_right>form>.code>input{
            width: 150px;
        }
        .login>.login_main>.main_right>form>.code .code_img{
            width: 90px;
            height: 35px;
            float: right;
            margin-right: 50px;
            cursor: pointer;
        }
        .login>.login_main>.main_right>form input:focus{
            border: 1px solid #999;
        }
        .login>.login_main>.main_right>form .Button {
            position: relative;
            top: -2px;
            display: inline-block;
            padding: 0px;
            margin: 0px 45px 0px 50px;
            width: 100px;
            height: 37px;
            background-color: #0064c8;
            color:#fff;
            font-size: 16px;
            text-align: center;
            line-height: 37px;
            border-radius: 3px;
            border: none;
        }
        .login>.login_main>.main_right>form .Button:hover {
            cursor:pointer;
        }
        .login>.login_main>.main_right>form .zc:hover {
            cursor:pointer;
        }
        .login>.login_main>.main_right>form .yes_registered{
            display: inline-block;
            width: 100px;
            height: 37px;
            line-height: 37px;
            text-align: center;
            background-color: #0064c8;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            color:#fff;
            text-decoration: none;

        }
        .login>.login_main>.main_right>form>a:hover{
            background-color: #0058af;
        }
        .login>.login_footer>p{
            font-size: 14px;
            color:#eee;
            line-height: 30px;
        }
        .login_idy {
            border: 1px solid #d3d8dc;
            border-radius: 3px;
            outline: none;
            height: 35px;
            width: 250px;
            margin: 0px 0px 20px 50px;
        }

        .login>.login_main>.main_right>form .zc {
            position: relative;
            top:8px;
            right:50px;
            display: inline-block;
            padding: 0px;
            /*margin: 0px 45px 0px 50px;*/
            width: 100px;
            height: 37px;
            background-color: #0064c8;
            color:#fff;
            font-size: 16px;
            text-align: center;
            line-height: 37px;
            border-radius: 3px;
            border: none;
        }
        /*login 结束*/

    </style>
    <script type="text/javascript" src='${pageContext.request.contextPath}/statics/jquery-1.11.3.js'></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#login').click(function () {
            if ($('#idy').val() === '公民'){
                $.ajax({
                    url: '${pageContext.request.contextPath}/driverlogin',
                    data: {
                        'name': $('#uname').val(),
                        'phone': $('#pwd').val()
                    },
                    dataType:'text',
                    success:function (data) {
                        // alert(data);
                        if (data == "success!") {
                            window.location.href = '${pageContext.request.contextPath}/User/User.jsp';
                        }
                    }
                })
            } else {
                $.ajax({
                    url: '${pageContext.request.contextPath}/policemenlogin',
                    data: {
                        'name': $('#uname').val(),
                        'phone': $('#pwd').val()
                    },
                    dataType:'text',
                    success:function (data) {
                        // alert(data);
                        if (data == "success!") {
                            window.location.href = '${pageContext.request.contextPath}/Police/police.jsp';
                        }
                    }
                })
            }
        })

        $('#zc').click(function () {
            if ($('#idy').val() === '公民') {
                window.location.href = '${pageContext.request.contextPath}/registered/registeredUser.jsp';
            } else {
                window.location.href = '${pageContext.request.contextPath}/registered/registeredPolice.jsp';
            }
        })
    })
</script>
<div class="login">
    <div class="login_title">
        <p><img src="./images/jinghui.png" style="width:80px;height:80px;margin-right:30px;"/>西安市临潼分局交通违章管理系统平台</p>
    </div>
    <div class="login_main">
        <div class="main_left"></div>l
        <div class="main_right">
            <div class="right_title">用户登录</div>
            <form>
                <div class="username">
                    <img src="./images/username.png" >
                    <input type="text" placeholder="请输入用户名" name="name" id="uname">
                </div>
                <div class="password">
                    <img src="./images/password.png" >
                    <input type="text" placeholder="请输入手机号" name="phone" id="pwd">
                </div>
                <div>
                    <select class="login_idy" id="idy" >
                        <option value="公民">公民</option>
                        <option value="警察">警察</option>
                    </select>
                </div>
                <div >
                    <input class = "Button" type="button" name="Button" value="登    录" id="login" >
                    <input class = "zc" type="button" name="Button" value="注    册" id="zc" >

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>