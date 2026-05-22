import { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [tweets, setTweets] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    axios.get('http://localhost:3000/tweet', {
          auth: {
            username: 'mamba@gmail.com',
            password: '123456'
          }
        })
      .then(response => {
        setTweets(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error("Beklenmedik bir ters kroşe:", error);
        setLoading(false);
      });
  }, []);

  return (
    <div style={{ maxWidth: '600px', margin: '50px auto', padding: '20px', color: 'white', fontFamily: 'sans-serif' }}>
      <h1 style={{ textAlign: 'center', marginBottom: '30px' }}>Twitter Full-Stack Antrenmanı</h1>

      {loading ? (
        <div style={{ textAlign: 'center', color: '#ffcc00', padding: '20px', border: '1px solid #ffcc00' }}>
          Ring hazırlanıyor... (Veriler çekiliyor) 🥊
        </div>
      ) : tweets.length === 0 ? (
        <div style={{ textAlign: 'center', color: '#888' }}>
          Henüz hiç tweet yok. İlk yumruğu sen at!
        </div>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
          {tweets.map(tweet => (
            <div
              key={tweet.id}
              style={{
                backgroundColor: '#15202b',
                border: '1px solid #38444d',
                borderRadius: '12px',
                padding: '15px',
                boxShadow: '0 4px 6px rgba(0,0,0,0.3)'
              }}
            >
              <div style={{ fontWeight: 'bold', fontSize: '18px', color: '#1da1f2', marginBottom: '10px' }}>
                {tweet.user ? tweet.user.fullName : "Şampiyon"}
              </div>
              <div style={{ fontSize: '16px', lineHeight: '1.5' }}>
                {tweet.message}
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default App;