class HomepageController < ApplicationController

  before_action :authorized?

  def leaderboard
    @users = User.all
    @users.max_by{ |user| user.amount}
  end

  def index
    @user = User.find(session[:user_id])
  end

  def real
    @users = User.all
  end
  
  def realgame
  end

  def simgame
    @user1 = User.find(session[:user_id])
    @user2 = User.find(params[:id])
    @simgames = Simgame.new
    @players = Player.all
  end
  
  def sim
    @users = User.all
  end
  
  def create
  end
  
  def result 
    @u1 = 0
    @u2 = 0 
    @p1_sps = []
    @p2_sps = []
    @p1_shot_perc = []
    @p2_shot_perc = [] 
    @p1 = [0,0,0,0,0]
    @p2 = [0,0,0,0,0]
    @user1 = User.find(session[:user_id])
    @user2 = User.find(params[:id])
    players = Player.all
    @p1_1 = Player.find(params["simgame"]["u1p1_id"])
    @p2_1 = Player.find(params["simgame"]["u1p2_id"])
    @p3_1 = Player.find(params["simgame"]["u1p3_id"])
    @p4_1 = Player.find(params["simgame"]["u1p4_id"])
    @p5_1 = Player.find(params["simgame"]["u1p5_id"])
    cpu_player_id = 1+rand(players.size)
    @p1_2 = players[cpu_player_id][:full_name]
    @p2_sps << players[cpu_player_id][:sps]
    @p2_shot_perc << players[cpu_player_id][:shot_perc]
    cpu_player_id = 1+rand(players.size)
    @p2_2 = players[cpu_player_id][:full_name]
    @p2_sps << players[cpu_player_id][:sps]
    @p2_shot_perc << players[cpu_player_id][:shot_perc]
    cpu_player_id = 1+rand(players.size)
    @p3_2 = players[cpu_player_id][:full_name]
    @p2_sps << players[cpu_player_id][:sps]
    @p2_shot_perc << players[cpu_player_id][:shot_perc]
    cpu_player_id = 1+rand(players.size)
    @p4_2 = players[cpu_player_id][:full_name]
    @p2_sps << players[cpu_player_id][:sps]
    @p2_shot_perc << players[cpu_player_id][:shot_perc]
    cpu_player_id = 1+rand(players.size)
    @p5_2 = players[cpu_player_id][:full_name]
    @p2_sps << players[cpu_player_id][:sps]
    @p2_shot_perc << players[cpu_player_id][:shot_perc]
    @p1_sps << @p1_1.sps
    @p1_sps << @p2_1.sps
    @p1_sps << @p3_1.sps
    @p1_sps << @p4_1.sps
    @p1_sps << @p5_1.sps 
    @p1_shot_perc << @p1_1.shot_perc
    @p1_shot_perc << @p2_1.shot_perc
    @p1_shot_perc << @p3_1.shot_perc
    @p1_shot_perc << @p4_1.shot_perc
    @p1_shot_perc << @p5_1.shot_perc

    #@u1 = 0
    #@u2 = 0 
    #@p1_sps = []
    #@p2_sps = []
    #@p1_shot_perc = []
    #@p2_shot_perc = [] 
    #@p1 = [0,0,0,0,0]
    #@p2 = [0,0,0,0,0]

    @p1_sps.each do |sps|
      index = @p1_sps.index(sps)
      1200.times do
        chance = rand(1000)     
        if @p1_sps[index] > chance
          chance2 = rand(100)
          if @p1_shot_perc[index]>chance2
            @u1 +=2
            @p1[index] +=2
          end         
        end
      end 
    end

    #@user1.exp_score

    @p2_sps.each do |sps|
      index = @p2_sps.index(sps)
      1200.times do
        chance = rand(1000)     
        if @p2_sps[index] > chance
          chance2 = rand(100)
          if @p2_shot_perc[index]>chance2
            @u2 +=2
            @p2[index] +=2
          end         
        end
      end 
    end
  end
end