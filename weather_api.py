import requests

def get_weather(city, api_key):
    base_url = "https://api.openweathermap.org/data/2.5/weather"
    
    params = {
        'q': city,
        'appid': api_key,
        'units': 'metric'  # temperature in Celsius
    }
    
    response = requests.get(base_url, params=params)
    
    if response.status_code == 200:
        data = response.json()
        
        temperature = data['main']['temp']
        wind_speed = data['wind']['speed']
        description = data['weather'][0]['description']
        weather = data['weather'][0]['main']
        
        print(f"Weather report for {city.title()}:")
        print(f"Temperature: {temperature}°C")
        print(f"Wind Speed: {wind_speed} m/s")
        print(f"Description: {description.capitalize()}")
        print(f"Weather: {weather}")
        
    else:
        print(f"Failed to get weather data for {city}. Error code: {response.status_code}")
        print("Response content:", response.text)  # Helpful for debugging
        

if __name__ == "__main__":
    # Replace with your actual API key
    API_KEY = "b1b15e88fa797225412429c1c50c122a1"
    
    city = input("Enter city name: ")
    get_weather(city, API_KEY)

