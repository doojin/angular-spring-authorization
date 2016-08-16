function config($stateProvider, $urlMatcherFactoryProvider) {

    $urlMatcherFactoryProvider.strictMode(false);

    $stateProvider
        .state('article-list', {
            url: '',
            templateUrl: '/static/templates/article-list.html',
            controller: 'ArticleListController'
        })
        .state('new-article', {
            url: '/new-article',
            templateUrl: '/static/templates/new-article.html'
        })
        .state('user-list', {
            url: '/user-list',
            templateUrl: '/static/templates/user-list.html',
            controller: 'UserListController'
        })
        .state('new-user', {
            url: '/new-user',
            templateUrl: '/static/templates/new-user.html'
        });
}

export default config;