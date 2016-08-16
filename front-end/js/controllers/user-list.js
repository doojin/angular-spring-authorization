function UserListController($scope) {
    $scope.users = [];

    for (let i = 0; i < 25; i++) {
        $scope.users.push({
            account: 'dmitry.papka@gmail.com',
            role: 'Admin'
        });
    }
}

export default UserListController;