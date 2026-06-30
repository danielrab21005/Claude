const testimonials = [
  {
    quote: "NRS Tap Forward transformed how we collect tithes. Our giving is up 34% since we switched, and the reports save our treasurer hours every week.",
    name: "Pastor Marcus Webb",
    role: "Senior Pastor",
    org: "Grace Fellowship Church",
  },
  {
    quote: "We manage 12 services and 20+ events a month. The event tracking alone was worth the switch. Everything is in one place and our staff actually uses it.",
    name: "Sis. Adrienne Cole",
    role: "Church Administrator",
    org: "New Life Worship Center",
  },
  {
    quote: "Our congregation loves tapping to give — it feels modern and respectful of their time. The analytics help us plan our outreach budget with real data.",
    name: "Bishop T. Hargrove",
    role: "Lead Bishop",
    org: "Kingdom Harvest Ministries",
  },
];

export default function Testimonials() {
  return (
    <section className="py-24 bg-white">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="text-center mb-16">
          <p className="text-indigo-600 font-semibold text-sm uppercase tracking-widest mb-3">Testimonials</p>
          <h2 className="text-3xl sm:text-4xl font-bold text-slate-900">Trusted by ministry leaders</h2>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {testimonials.map((t) => (
            <div key={t.name} className="bg-slate-50 rounded-2xl p-8 border border-slate-200 flex flex-col">
              <svg className="w-8 h-8 text-indigo-300 mb-4" fill="currentColor" viewBox="0 0 24 24">
                <path d="M14.017 21v-7.391c0-5.704 3.731-9.57 8.983-10.609l.995 2.151c-2.432.917-3.995 3.638-3.995 5.849h4v10h-9.983zm-14.017 0v-7.391c0-5.704 3.748-9.57 9-10.609l.996 2.151c-2.433.917-3.996 3.638-3.996 5.849h3.983v10h-9.983z" />
              </svg>
              <p className="text-slate-600 text-sm leading-relaxed mb-6 flex-1">{t.quote}</p>
              <div>
                <p className="font-semibold text-slate-900">{t.name}</p>
                <p className="text-xs text-slate-500">{t.role} · {t.org}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
