function MainController($scope, $http) {
    const googleAuthButton = document.getElementById('googleAuthButton');

    gapi.load('auth2', () => {
        let auth2 = gapi.auth2.init({
            client_id: '240867801941-rbvltdr626f27pehsf8qack05caslj02.apps.googleusercontent.com',
            cookiepolicy: 'single_host_origin'
        });

        auth2.attachClickHandler(googleAuthButton, {}, (user) => {
            let token = user.getAuthResponse().id_token;
            let username = user.getBasicProfile().getEmail();
            $http({
                method: 'POST',
                url: '/login',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                transformRequest: function(obj) {
                    var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    return str.join("&");
                },
                data: { username, password: token }
            });
        });
    });
}

export default MainController;