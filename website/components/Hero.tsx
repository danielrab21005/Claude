export default function Hero() {
  return (
    <section className="pt-32 pb-20 bg-gradient-to-br from-slate-900 via-indigo-950 to-slate-900 relative overflow-hidden">
      {/* Background grid */}
      <div className="absolute inset-0 bg-[url('data:image/svg+xml,%3Csvg width=%2260%22 height=%2260%22 viewBox=%220 0 60 60%22 xmlns=%22http://www.w3.org/2000/svg%22%3E%3Cg fill=%22none%22 fill-rule=%22evenodd%22%3E%3Cg fill=%22%234f46e5%22 fill-opacity=%220.08%22%3E%3Cpath d=%22M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z%22/%3E%3C/g%3E%3C/g%3E%3C/svg%3E')] opacity-40" />

      <div className="relative max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 text-center">
        <div className="inline-flex items-center gap-2 bg-indigo-500/20 border border-indigo-400/30 text-indigo-300 text-sm px-4 py-1.5 rounded-full mb-8">
          <span className="w-2 h-2 rounded-full bg-indigo-400 animate-pulse" />
          Purpose-built for Houses of Worship
        </div>

        <h1 className="text-4xl sm:text-5xl lg:text-6xl font-bold text-white leading-tight tracking-tight mb-6">
          Modern Giving for<br />
          <span className="text-transparent bg-clip-text bg-gradient-to-r from-indigo-400 to-violet-400">
            Your Congregation
          </span>
        </h1>

        <p className="max-w-2xl mx-auto text-lg text-slate-300 mb-10 leading-relaxed">
          NRS Tap Forward is the all-in-one donation POS, event tracker, and congregation management
          platform — designed from the ground up for churches, mosques, synagogues, and houses of worship.
        </p>

        <div className="flex flex-col sm:flex-row gap-4 justify-center mb-16">
          <a
            href="#contact"
            className="inline-flex items-center justify-center gap-2 bg-indigo-600 hover:bg-indigo-500 text-white font-semibold px-8 py-4 rounded-xl transition-colors text-base shadow-lg shadow-indigo-900/40"
          >
            Start Free Trial
            <svg className="w-5 h-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17 8l4 4m0 0l-4 4m4-4H3" />
            </svg>
          </a>
          <a
            href="#how-it-works"
            className="inline-flex items-center justify-center gap-2 bg-white/10 hover:bg-white/20 border border-white/20 text-white font-semibold px-8 py-4 rounded-xl transition-colors text-base"
          >
            <svg className="w-5 h-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M14.828 14.828a4 4 0 01-5.656 0M9 10h.01M15 10h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
            See How It Works
          </a>
        </div>

        {/* Dashboard mockup */}
        <div className="relative max-w-5xl mx-auto">
          <div className="bg-slate-800/80 backdrop-blur border border-slate-700/60 rounded-2xl shadow-2xl overflow-hidden">
            {/* Browser bar */}
            <div className="flex items-center gap-2 px-4 py-3 bg-slate-900/60 border-b border-slate-700/60">
              <div className="flex gap-1.5">
                <div className="w-3 h-3 rounded-full bg-red-500/80" />
                <div className="w-3 h-3 rounded-full bg-yellow-500/80" />
                <div className="w-3 h-3 rounded-full bg-green-500/80" />
              </div>
              <div className="flex-1 mx-4 bg-slate-700/60 rounded px-3 py-1 text-xs text-slate-400">
                app.nrstapforward.com/dashboard
              </div>
            </div>

            {/* Dashboard content */}
            <div className="p-6 grid grid-cols-1 md:grid-cols-3 gap-4 text-left">
              {/* Stat cards */}
              {[
                { label: "Total Donations (Month)", value: "$24,318", change: "+12%", color: "indigo" },
                { label: "Active Members", value: "1,204", change: "+3%", color: "violet" },
                { label: "Upcoming Events", value: "8", change: "Next: Sunday Service", color: "emerald" },
              ].map((stat) => (
                <div key={stat.label} className="bg-slate-700/40 rounded-xl p-4 border border-slate-600/40">
                  <p className="text-xs text-slate-400 mb-1">{stat.label}</p>
                  <p className="text-2xl font-bold text-white mb-1">{stat.value}</p>
                  <p className="text-xs text-emerald-400">{stat.change}</p>
                </div>
              ))}

              {/* Recent donations */}
              <div className="md:col-span-2 bg-slate-700/40 rounded-xl p-4 border border-slate-600/40">
                <p className="text-sm font-semibold text-white mb-3">Recent Donations</p>
                <div className="space-y-2">
                  {[
                    { name: "J. Williams", amount: "$200", method: "Tap", time: "2 min ago" },
                    { name: "M. Johnson", amount: "$50", method: "Card", time: "14 min ago" },
                    { name: "Anonymous", amount: "$500", method: "Tap", time: "32 min ago" },
                    { name: "T. Davis", amount: "$25", method: "QR", time: "1 hr ago" },
                  ].map((d) => (
                    <div key={d.name + d.time} className="flex items-center justify-between text-xs">
                      <span className="text-slate-300 w-28">{d.name}</span>
                      <span className="bg-indigo-500/20 text-indigo-300 px-2 py-0.5 rounded">{d.method}</span>
                      <span className="font-semibold text-white">{d.amount}</span>
                      <span className="text-slate-500">{d.time}</span>
                    </div>
                  ))}
                </div>
              </div>

              {/* Next event */}
              <div className="bg-slate-700/40 rounded-xl p-4 border border-slate-600/40">
                <p className="text-sm font-semibold text-white mb-3">Next Event</p>
                <div className="text-xs text-slate-300 space-y-1">
                  <p className="text-base font-bold text-white">Sunday Service</p>
                  <p className="text-slate-400">Jul 6, 2026 · 10:00 AM</p>
                  <p className="text-slate-400">Expected attendance: 320</p>
                  <div className="mt-2 w-full bg-slate-600 rounded-full h-1.5">
                    <div className="bg-indigo-500 h-1.5 rounded-full w-3/5" />
                  </div>
                  <p className="text-slate-400">192 / 320 registered</p>
                </div>
              </div>
            </div>
          </div>

          {/* Glow */}
          <div className="absolute -inset-4 bg-indigo-600/10 blur-3xl rounded-3xl -z-10" />
        </div>
      </div>
    </section>
  );
}
