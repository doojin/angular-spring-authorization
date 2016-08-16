function ArticleListController($scope, articleRepository) {
    $scope.articles = [];
    articleRepository.findAll()
        .then((articles) => $scope.articles = articles);
}

export default ArticleListController;