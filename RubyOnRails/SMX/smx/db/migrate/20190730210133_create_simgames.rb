class CreateSimgames < ActiveRecord::Migration[5.2]
  def change
    create_table :simgames do |t|
      t.integer :user_id1      
      t.integer :user_id2
      t.integer :u1p1_id
      t.integer :u1p2_id
      t.integer :u1p3_id
      t.integer :u1p4_id
      t.integer :u1p5_id
      t.integer :u2p1_id
      t.integer :u2p2_id
      t.integer :u2p3_id
      t.integer :u2p4_id
      t.integer :u2p5_id

      t.timestamps
    end
  end
end
