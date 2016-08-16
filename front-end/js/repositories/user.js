function userRepository($http, $q) {
    return {
        findAll: () => {
            let deferred = $q.defer();
            $http.get('/user/all')
                .then((response) => deferred.resolve(response.data));
            return deferred.promise;
        }
    };
}

export default userRepository;