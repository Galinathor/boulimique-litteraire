(function () {
    angular.module('boulimiqueLitteraire').
        controller('RecipeCtrl', ['$scope', 'RecipeFactory', '$routeParams',
        function ($scope, RecipeFactory, $routeParams) {

        $scope.recipe = {};

        function init(){
            RecipeFactory.getById($routeParams.id).
            then(function(data){
                $scope.recipe = data;
            }, function(error){
                console.log(error.data.message);
            })
        }

        init();
    }]);
}());