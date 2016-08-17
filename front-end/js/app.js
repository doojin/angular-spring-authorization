import '../../node_modules/angular/angular.min';
import '../../node_modules/angular-ui-router/release/angular-ui-router.min'

import config from './config';

import MainController from './controllers/main';
import ArticleListController from './controllers/article-list';
import UserListController from './controllers/user-list';
import userRepository from './repositories/user';
import articleRepository from './repositories/article';

let app = angular.module('angularSpringAuthorization', ['ui.router']);

app.config(['$stateProvider', '$urlMatcherFactoryProvider', config]);
app.controller('MainController', ['$scope', '$http', MainController]);
app.controller('ArticleListController', ['$scope', 'articleRepository', ArticleListController]);
app.controller('UserListController', ['$scope', 'userRepository', UserListController]);
app.factory('userRepository',['$http', '$q', userRepository]);
app.factory('articleRepository',['$http', '$q', articleRepository]);
app.run(['$state', '$stateParams', function($state, $stateParams) {}]);