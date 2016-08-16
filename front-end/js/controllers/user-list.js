function UserListController($scope, userRepository) {
    $scope.users = [];
    userRepository.findAll()
        .then((users) => $scope.users = users);
}

export default UserListController;