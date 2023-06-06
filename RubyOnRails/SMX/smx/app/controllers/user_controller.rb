class UserController < ApplicationController
  
 before_action :authorized?, except: [:new,:create,:login, :index]

  def index
  end

  def update
  end
  
  def login
  end
  
  def new 
    @user = User.new
  end

  def profile
    @user = User.find(params[:id])
  end

  def create
    @user = User.new(user_params)
      if @user.valid?
        @user.save
        session[:user_id] = @user.id
        redirect_to profile_path(@user)
      else
        flash.now[:message] = @user.errors.full_messages[0]
        render :new
      end
  end

  def destroy
    User.find(params[:id]).destroy
    redirect_to login_path
  end

  private
  def user_params
    params.require(:user).permit(:full_name,:username,:password,:team_name,:email,:amount)
  end
end
