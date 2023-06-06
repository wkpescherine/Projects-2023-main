class Simgame < ApplicationRecord
    
    has_many :players
    has_many :users
end
