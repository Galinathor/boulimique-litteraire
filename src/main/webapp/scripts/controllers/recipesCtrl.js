(function () {
    angular.module('boulimiqueLitteraire').
        controller('RecipesCtrl', ['$scope', 'RecipeFactory',
        function ($scope, RecipeFactory) {

        $scope.recipes = [];
        $scope.currentPage = 1;
        $scope.itemsPerPage = 3;
        $scope.maxSize = 5;

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        function sortRecipes(){
            $scope.recipes.sort(function (a, b) {
                if (a.creationDate > b.creationDate)
                    return -1;
                if (a.creationDate < b.creationDate)
                    return 1;
                return 0;
            });
        }
        function init() {
            RecipeFactory.getAll().
            then(function(data) {
                $scope.recipes = data;
                sortRecipes();
            }, function(error){
                console.log(error.data.message);
            })
        }
        init();
    }]);
}());