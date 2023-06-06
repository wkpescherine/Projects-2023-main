class SessionController < ApplicationController
  def new
  end  

  def create 
    @user = User.find_by(username: params[:username])
    if @user && @user.authenticate(params[:password_digest])
        session[:user_id] = @user.id 
        redirect_to profile_path(@user)
    else
        flash[:message] = "Incorrect Password or username"
        render :new 
    end
  end

  def destroy
    session[:user_id] = nil
    redirect_to front_path
  end
end
