import '../../node_modules/angular/angular.min';
import '../../node_modules/angular-ui-router/release/angular-ui-router.min'

import config from './config';

import ArticleListController from './controllers/article-list';
import UserListController from './controllers/user-list';

let app = angular.module('angularSpringAuthorization', ['ui.router']);

app.config(['$stateProvider', '$urlMatcherFactoryProvider', config]);
app.controller('ArticleListController', ['$scope', ArticleListController]);
app.controller('UserListController', ['$scope', UserListController]);

app.run(['$state', '$stateParams', function($state, $stateParams) {}]);