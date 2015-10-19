(function () {
    angular.module('boulimiqueLitteraire').
        controller('RecipeCtrl', ['$scope', 'RecipeFactory', 'RecipeCommentFactory', '$routeParams',
        function ($scope, RecipeFactory, RecipeCommentFactory, $routeParams) {

        $scope.recipe = {};
        $scope.comment = {};
        $scope.comments = [];

        $scope.sendComment = function(comment){
            RecipeCommentFactory.save(comment).
            then(function(data){
                $scope.comments.push(data);
                $scope.comment = {};
            }, function(error){
                console.log(error.data.message);
            })
        }

        function init(){
            RecipeFactory.getById($routeParams.id).
            then(function(data){
                $scope.recipe = data;
            }, function(error){
                console.log(error.data.message);
            })
            RecipeCommentFactory.getAll().
            then(function(data){
                $scope.comments = data;
            }, function(error){
                console.log(error.data.message);
            })
        }

        init();
    }]);
}());