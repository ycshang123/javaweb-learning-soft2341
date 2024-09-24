<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>响应不同类型的文件</title>
    <style>
        ul li {
            list-style: none;
            float: left;
            margin-top: 40px;
        }

        ul li a {

            padding: 20px 50px;
            height: 40px;
            background-color: #00897b;
            color: #fff;
            box-sizing: border-box;
            margin-right: 10px;
            font-size: 16px;
            text-decoration: none;
        }

        ul li a:hover {
            background-color: #ea8363;
        }
    </style>
</head>
<body>
<h1><%= "设置 Content-Type 不同类型的资源" %>
</h1>
<h2><%= "根据不同的参数类型返回不同的资源" %>
</h2>
<br/>
<ul>
    <li>
        <a href="res?type=html">返回HTML</a>
    </li>
    <li>
        <a href="res?type=json">返回JSON</a>
    </li>
    <li>
        <a href="res?type=img">返回图片</a>
    </li>
    <li>
        <a href="res?type=pdf">返回pdf</a>
    </li>
</ul>
</body>
</html>