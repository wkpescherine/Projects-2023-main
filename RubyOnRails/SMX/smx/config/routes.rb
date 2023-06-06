Rails.application.routes.draw do
  get 'contact_requests/index'
  get 'contact_requests/request'
  #USER ROUTRES
  get "/smx", to:"user#index", as:"front"
  get "/smx/new", to:"user#new", as:"users"
  get "/smx/profile/:id", to:"user#profile", as:"profile"
  post "/smx/new", to:"user#create"
  delete "/smx/profile/:id", to:"user#destroy"
  
  #HOMEPAGE ROUTES
  get "/homepage", to:"homepage#index", as:"homepage"
  get "/homepage/real", to:"homepage#real", as:"real"
  get "/homepag/sim", to:"homepage#sim", as:"sim"
  get "/homepage/realgame", to:"homepage#realgame", as:"realgame"
  get "/homepage/simgame/:id", to:"homepage#simgame", as:"simgame"
  get "/homepage/results", to:"homepage#results", as:"results"
  get "/homepage/leaderboard", to:"homepage#leaderboard", as:"leaderboard"
  post "/homepage/simgame", to:"homepage#create", as:"simsgame"
  post "/homepage/simgame/:id", to:"homepage#result", as:"simgames"
  
  #SESSION
  get "/smx/login", to: "session#new", as: "login"
  post "/session", to: "session#create"  
  delete "/logout", to: "session#destroy", as:"logout"

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
