class ContactRequestsController < ApplicationController
  def index
  end

  def request
    @contactrequest = ContactRequest.new
    @user = User.find(sessions[:user_id])
  end

  def create

  end
end
