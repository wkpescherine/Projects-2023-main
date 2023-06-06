class User < ApplicationRecord
    
    has_secure_password

    validates :username, presence: true
    validates :username, uniqueness: true
    validates :email, presence: true
    validates :email, uniqueness: true
    validates :team_name, presence: true
    validates :team_name, uniqueness: true


    def exp_score
        self.players.each do |sps|
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
          return score
    end
end
