defmodule M do
  def print do
    word = IO.gets("Enter some thing here") |> String.trim
    IO.puts "Test #{word}"
    practice()
  end

  def practice do
    IO.puts "Another test"
    test_variables()
  end

  def test_variables do
    number = 12
    decimal = 123.123
    string = "String words"
    IO.puts number
    IO.puts decimal
    IO.puts string
  end
end
