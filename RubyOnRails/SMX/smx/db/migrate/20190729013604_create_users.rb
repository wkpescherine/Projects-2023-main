class CreateUsers < ActiveRecord::Migration[5.2]
  def change
    create_table :users do |t|
      t.string :full_name
      t.string :username
      t.string :team_name
      t.string :password_digest
      t.string :email
      t.integer :amount

      t.timestamps
    end
  end
end
