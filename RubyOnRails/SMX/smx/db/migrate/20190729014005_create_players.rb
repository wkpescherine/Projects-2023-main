class CreatePlayers < ActiveRecord::Migration[5.2]
  def change
    create_table :players do |t|
      t.string :full_name
      t.string :position
      t.integer :sps
      t.integer :shot_perc

      t.timestamps
    end
  end
end
