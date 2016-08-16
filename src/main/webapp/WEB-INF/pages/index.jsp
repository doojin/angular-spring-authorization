<!DOCTYPE html>
<html ng-app="angularSpringAuthorization">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/css/app.css"/>
    <script src="/static/js/app.js"></script>
    <title>Article List</title>
</head>
<body>
<nav class="top-bar">
    <section class="top-bar-section">
        <ul class="asauthMenu">
            <li class="asauthMenu__item"><a ui-sref="article-list">Article List</a></li>
            <li class="asauthMenu__item"><a ui-sref="user-list">User List</a></li>
            <li class="asauthMenu__item"><a class="small radius button asauthMenu__item__button">Log in</a></li>
        </ul>
    </section>
</nav>

<div class="row">
    <div class="small-12 columns asauth" ui-view></div>
</div>
</body>
</html>