(function () {
    angular.module('boulimiqueLitteraire').
        controller('BookCtrl', ['$scope', 'BookFactory', '$routeParams',
        function ($scope, BookFactory, $routeParams) {

        $scope.book = {};

        function init(){
            BookFactory.getById($routeParams.id).
            then(function(data){
                $scope.book = data;
            }, function(error){
                console.log(error.data.message);
            })
        }

        init();
    }]);
}());