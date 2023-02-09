var app = angular.module("springDemo", [])

app.controller("AppCtrl", function ($scope, $http) {
    $scope.websites = [];
    let test = [];

    // $http.get('localhost:8080/api/stackoverflow').then(function(data){
    //     $scope.websites = data;
    //     // console.log(data)
    // });
    // Simple GET request example:
    $http({
        method: 'GET',
        url: 'http://localhost:8080/api/stackoverflow'
    }).then(function successCallback(response) {
        $scope.websites = response;
        // this callback will be called asynchronously
        // when the response is available
    });
})