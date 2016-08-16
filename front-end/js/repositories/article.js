function articleRepository($http, $q) {
    return {
        findAll: () => {
            let deferred = $q.defer();
            $http.get('/article/all')
                .then((response) => deferred.resolve(response.data));
            return deferred.promise;
        }
    };
}

export default articleRepository;