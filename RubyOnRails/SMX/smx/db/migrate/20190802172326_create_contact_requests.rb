class CreateContactRequests < ActiveRecord::Migration[5.2]
  def change
    create_table :contact_requests do |t|
      t.integer :user_id
      t.string :body

      t.timestamps
    end
  end
end
